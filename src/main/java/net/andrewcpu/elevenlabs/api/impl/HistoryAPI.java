package net.andrewcpu.elevenlabs.api.impl;

import net.andrewcpu.elevenlabs.api.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.model.history.History;
import net.andrewcpu.elevenlabs.model.history.HistoryItem;
import net.andrewcpu.elevenlabs.requests.history.*;

import java.io.File;

public class HistoryAPI extends ElevenLabsAPI {

	public History getHistory() {
		return sendRequest(new GetHistoryRequest()).getResult();
	}

	public History getHistory(int pageSize, String afterHistoryId) {
		return sendRequest(new GetHistoryRequest(pageSize, afterHistoryId)).getResult();
	}

	public History getHistory(String afterHistoryId) {
		return sendRequest(new GetHistoryRequest(afterHistoryId)).getResult();
	}

	public HistoryItem getHistoryItem(String historyItemId) {
		return sendRequest(new GetHistoryItemByIdRequest(historyItemId)).getResult();
	}

	public String deleteHistoryItem(String historyItemId) {
		return sendRequest(new DeleteHistoryItemRequest(historyItemId)).getResult();
	}

	public File getHistoryItemAudio(String historyItemId) {
		return sendRequest(new GetHistoryItemAudioRequest(historyItemId)).getResult();
	}

	public File getHistoryItemAudio(String... historyItemIds) {
		return sendRequest(new PostDownloadHistoryItemsRequest(historyItemIds)).getResult();
	}
}
