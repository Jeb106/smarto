package com.slyak.mirrors.web;

import com.slyak.mirrors.domain.ProjectHost;
import com.slyak.mirrors.domain.HostGroupScript;
import com.slyak.mirrors.dto.GroupHostResponse;
import com.slyak.mirrors.service.GroupScriptCallback;
import com.slyak.mirrors.service.MirrorManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * .
 *
 * @author stormning 2018/4/24
 * @since 1.3.0
 */
@Controller
@Slf4j
public class SSH2Controller {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private MirrorManager mirrorManager;


    @MessageMapping("/ssh/exec")
    public void handle(Message<Long> message) throws IOException {
        Long groupId = message.getPayload();
        mirrorManager.execGroupScripts(groupId, new GroupScriptCallback() {
            @Override
            public void processOut(ProjectHost projectHost, HostGroupScript hostGroupScript, String out) {
                messagingTemplate.convertAndSend("/ssh/logs/", new GroupHostResponse(projectHost.getId(), out));
            }

            @Override
            public void processError(ProjectHost projectHost, HostGroupScript hostGroupScript, String error) {
                messagingTemplate.convertAndSend("/ssh/logs/", new GroupHostResponse(projectHost.getId(), error));
            }
        });
    }
}
