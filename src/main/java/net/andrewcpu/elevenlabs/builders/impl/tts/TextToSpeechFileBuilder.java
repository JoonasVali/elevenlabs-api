package net.andrewcpu.elevenlabs.builders.impl.tts;

import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.builders.abstracts.AbstractSpeechGenerationBuilder;
import net.andrewcpu.elevenlabs.util.RequestResult;

import java.io.File;

public class TextToSpeechFileBuilder extends AbstractSpeechGenerationBuilder<TextToSpeechFileBuilder, File> {
	private String text;
	private String receivedLastRequestId;

	private String[] previousRequestIds;

	private String previousText;

	public String getText() {
		return text;
	}

	public TextToSpeechFileBuilder setText(String text) {
		this.text = text;
		return this;
	}

	@Override
	public TextToSpeechFileBuilder self() {
		return this;
	}

	@Override
	public File build() {
		RequestResult<File> result = ElevenLabs
				.getTextToSpeechAPI()
				.generateTextToSpeech(getVoiceId(), getText(),getModelId(), getGeneratedAudioOutputFormat(),getLatencyOptimization(), getVoiceSettings(), previousText, previousRequestIds);

		receivedLastRequestId = result.getRequestId();
		return result.getResult();
	}

	public String getReceivedLastRequestId() {
		return receivedLastRequestId;
	}

	public TextToSpeechFileBuilder setPreviousRequestIds(String[] previousRequestIds) {
		this.previousRequestIds = previousRequestIds;
		return this;
	}

	public TextToSpeechFileBuilder setPreviousText(String previousText) {
		this.previousText = previousText;
		return this;
	}
}
