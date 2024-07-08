package net.andrewcpu.elevenlabs.api.impl;

import net.andrewcpu.elevenlabs.api.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.enums.GeneratedAudioOutputFormat;
import net.andrewcpu.elevenlabs.enums.StreamLatencyOptimization;
import net.andrewcpu.elevenlabs.model.request.TextToSpeechRequest;
import net.andrewcpu.elevenlabs.model.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.requests.tts.PostTextToSpeechRequest;
import net.andrewcpu.elevenlabs.requests.tts.PostTextToSpeechStreamedRequest;
import net.andrewcpu.elevenlabs.util.RequestResult;

import java.io.File;
import java.io.InputStream;

public class TextToSpeechAPI extends ElevenLabsAPI {

	public RequestResult<File> generateTextToSpeech(String voiceId, String text, String modelId, VoiceSettings voiceSettings, String previousText, String[] previousRequestIds) {
		return sendRequest(new PostTextToSpeechRequest(voiceId, new TextToSpeechRequest(text, modelId, voiceSettings, previousText, previousRequestIds)));
	}

	public RequestResult<File> generateTextToSpeech(String voiceId, String text, String modelId, GeneratedAudioOutputFormat outputFormat, StreamLatencyOptimization streamLatencyOptimization, VoiceSettings voiceSettings, String previousText, String[] previousRequestIds) {
		return sendRequest(new PostTextToSpeechRequest(voiceId, new TextToSpeechRequest(text, modelId, voiceSettings, previousText, previousRequestIds), streamLatencyOptimization, outputFormat));
	}
	public RequestResult<InputStream> generateTextToSpeechStreamed(String voiceId, String text, String modelId, GeneratedAudioOutputFormat outputFormat, StreamLatencyOptimization streamLatencyOptimization, VoiceSettings voiceSettings, String previousText, String[] previousRequestIds) {
		return sendRequest(new PostTextToSpeechStreamedRequest(voiceId, new TextToSpeechRequest(text, modelId, voiceSettings, previousText, previousRequestIds), streamLatencyOptimization, outputFormat));
	}

	public RequestResult<InputStream> generateTextToSpeechStreamed(String voiceId, String text, String modelId, VoiceSettings voiceSettings, String previousText, String[] previousRequestIds) {
		return sendRequest(new PostTextToSpeechStreamedRequest(voiceId, new TextToSpeechRequest(text, modelId, voiceSettings, previousText, previousRequestIds)));
	}

}
