package net.andrewcpu.elevenlabs.builders.impl.tts;

import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.builders.abstracts.AbstractSpeechGenerationBuilder;
import net.andrewcpu.elevenlabs.util.RequestResult;

import java.io.InputStream;

public class TextToSpeechStreamedBuilder extends AbstractSpeechGenerationBuilder<TextToSpeechStreamedBuilder, InputStream> {
	private String text;

	private String lastRequestId;

	private String[] previousRequestIds;

	private String previousText;

	public String getText() {
		return text;
	}

	public TextToSpeechStreamedBuilder setText(String text) {
		this.text = text;
		return this;
	}

	@Override
	public TextToSpeechStreamedBuilder self() {
		return this;
	}

	@Override
	public InputStream build() {
		RequestResult<InputStream> result = ElevenLabs
				.getTextToSpeechAPI()
				.generateTextToSpeechStreamed(getVoiceId(), getText(),getModelId(), getGeneratedAudioOutputFormat(),getLatencyOptimization(), getVoiceSettings(), previousText, previousRequestIds);

		lastRequestId = result.getRequestId();
		return result.getResult();
	}

	public String getReceivedLastRequestId() {
		return lastRequestId;
	}

	public TextToSpeechStreamedBuilder setPreviousRequestIds(String[] previousRequestIds) {
		this.previousRequestIds = previousRequestIds;
		return this;
	}

	public TextToSpeechStreamedBuilder setPreviousText(String previousText) {
		this.previousText = previousText;
		return this;
	}
}
