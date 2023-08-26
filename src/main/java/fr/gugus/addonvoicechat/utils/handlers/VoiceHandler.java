package fr.gugus.addonvoicechat.utils.handlers;


import fr.nathanael2611.modularvoicechat.api.VoiceKeyEvent;
import fr.nathanael2611.modularvoicechat.client.voice.audio.MicroManager;
import fr.nathanael2611.modularvoicechat.config.ClientConfig;
import fr.nathanael2611.modularvoicechat.proxy.ClientProxy;

public class VoiceHandler {

    public boolean toggleOff;

    VoiceKeyEvent voiceKeyEvent = new VoiceKeyEvent(ClientProxy.getConfig().get(ClientConfig.TOGGLE_TO_TALK).getAsBoolean());

    public VoiceHandler(boolean megaphone){

        if (megaphone){


            if (MicroManager.isRunning() && !MicroManager.getHandler().isSending())
            {
                MicroManager.getHandler().start();
            }

        }else{

            if (MicroManager.isRunning() && MicroManager.getHandler().isSending()) {

                MicroManager.getHandler().stop();

            }

            if (toggleOff){

                voiceKeyEvent.setToggleToTalk(false);

            }

        }

    }

    public VoiceKeyEvent getVoiceKeyEvent() {
        return voiceKeyEvent;
    }
}
