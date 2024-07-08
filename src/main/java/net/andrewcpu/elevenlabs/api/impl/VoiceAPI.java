package net.andrewcpu.elevenlabs.api.impl;

import net.andrewcpu.elevenlabs.api.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.model.response.CreateVoiceResponse;
import net.andrewcpu.elevenlabs.model.response.ProjectsModelResponse;
import net.andrewcpu.elevenlabs.model.voice.Voice;
import net.andrewcpu.elevenlabs.model.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.requests.projects.GetProjectsRequest;
import net.andrewcpu.elevenlabs.requests.voices.*;

import java.io.File;
import java.util.List;
import java.util.Map;

public class VoiceAPI extends ElevenLabsAPI {

	public List<Voice> getVoices() {
		return sendRequest(new GetVoicesRequest()).getResult().getVoices();
	}

	public VoiceSettings getDefaultVoiceSettings() {
		return sendRequest(new GetDefaultVoiceSettingsRequest()).getResult();
	}

	public VoiceSettings getVoiceSettings(String voiceId) {
		return sendRequest(new GetVoiceSettingsRequest(voiceId)).getResult();
	}

	public Voice getVoice(String voiceId) {
		return sendRequest(new GetVoiceRequest(voiceId)).getResult();
	}

	public Voice getVoice(String voiceId, boolean withSettings) {
		return sendRequest(new GetVoiceRequest(voiceId, withSettings)).getResult();
	}

	public ProjectsModelResponse getProjects() {
		return sendRequest(new GetProjectsRequest()).getResult();
	}

	public String deleteVoice(String voiceId) {
		return sendRequest(new DeleteVoiceRequest(voiceId)).getResult();
	}

	public String editVoiceSettings(String voiceId, VoiceSettings settings) {
		return sendRequest(new PostEditVoiceSettingsRequest(voiceId, settings)).getResult();
	}

	public CreateVoiceResponse createVoice(String name, File[] files, String description, Map<String, String> labels) {
		return sendRequest(new PostAddVoiceRequest(name, files, description, labels)).getResult();
	}
	public String editVoice(String voiceId, String name, File[] files, String description, Map<String, String> labels) {
		return sendRequest(new PostEditVoiceRequest(voiceId, name, files, description, labels)).getResult();
	}
}
