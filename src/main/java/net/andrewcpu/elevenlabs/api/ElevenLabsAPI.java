package net.andrewcpu.elevenlabs.api;

import net.andrewcpu.elevenlabs.requests.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.util.ElevenNetworkUtil;
import net.andrewcpu.elevenlabs.util.RequestResult;

public abstract class ElevenLabsAPI {
	public ElevenLabsAPI() {
	}

	protected  <T> RequestResult<T> sendRequest(ElevenLabsRequest<T> request) {
		return ElevenNetworkUtil.sendRequest(request.getType(),request.getEndpoint(), request.getPayload(),request.getResponseClass());
	}
}
