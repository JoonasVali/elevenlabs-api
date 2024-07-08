package net.andrewcpu.elevenlabs.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;
import net.andrewcpu.elevenlabs.model.voice.VoiceSettings;

import java.util.Arrays;

public class TextToSpeechRequest extends ElevenModel {
	@JsonProperty("text")
	private String text;

	@JsonProperty("model_id")
	private String modelId;

	@JsonProperty("voice_settings")
	private VoiceSettings voiceSettings;

	@JsonProperty("previous_request_ids")
	private String[] previousRequestIds;

	@JsonProperty("previous_text")
	private String previousText;

	public TextToSpeechRequest(String text, String modelId, VoiceSettings voiceSettings) {
		this(text, modelId, voiceSettings, null, null);
	}

	public TextToSpeechRequest(String text, String modelId, VoiceSettings voiceSettings, String previousText, String[] previousRequestIds) {
		this.text = text;
		this.modelId = modelId;
		this.voiceSettings = voiceSettings;
		this.previousText = previousText;
		this.previousRequestIds = previousRequestIds;
	}

	public TextToSpeechRequest(String text, String modelId, VoiceSettings voiceSettings, String[] previousRequestIds) {
		this(text, modelId, voiceSettings, null, previousRequestIds);
	}

	public TextToSpeechRequest() {
	}

	@JsonIgnore
	public String getText() {
		return text;
	}

	@JsonIgnore
	public String getModelId() {
		return modelId;
	}

	@JsonIgnore
	public VoiceSettings getVoiceSettings() {
		return voiceSettings;
	}

	@JsonIgnore
	@Override
	public String toString() {
		return "TextToSpeechRequest{" +
				"text='" + text + '\'' +
				", modelId='" + modelId + '\'' +
				", voiceSettings=" + voiceSettings +
				", previousText" + previousText +
				", previousRequestIds" + Arrays.toString(previousRequestIds) +
				'}';
	}
}
