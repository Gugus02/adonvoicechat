package fr.gugus.addonvoicechat.utils.handlers;


import com.google.gson.JsonPrimitive;
import fr.nathanael2611.modularvoicechat.api.VoiceKeyEvent;
import fr.nathanael2611.modularvoicechat.client.voice.audio.MicroManager;
import fr.nathanael2611.modularvoicechat.config.ClientConfig;
import fr.nathanael2611.modularvoicechat.proxy.ClientProxy;

public class VoiceHandler {

    boolean toggleOff = false;

    public VoiceHandler(boolean megaphone){

        VoiceKeyEvent  voiceKeyEvent = new VoiceKeyEvent(ClientProxy.getConfig().get(ClientConfig.TOGGLE_TO_TALK).getAsBoolean());

        if (!voiceKeyEvent.isToggleToTalk()){
            this.toggleOff = true;
        }

        if (megaphone){

            if (!voiceKeyEvent.isToggleToTalk()) {

                ClientProxy.getConfig().set(ClientConfig.TOGGLE_TO_TALK, new JsonPrimitive(true));

            }
            if (MicroManager.isRunning() && !MicroManager.getHandler().isSending()) {

                MicroManager.getHandler().start();
            }

        }else{

            if (toggleOff){

                System.out.println("test togle");

                ClientProxy.getConfig().set(ClientConfig.TOGGLE_TO_TALK, new JsonPrimitive(false));

                if (MicroManager.isRunning() && MicroManager.getHandler().isSending()) {

                    MicroManager.getHandler().stop();

                }

            }else if (MicroManager.isRunning() && MicroManager.getHandler().isSending()) {

                MicroManager.getHandler().stop();

            }

        }

    }


}
