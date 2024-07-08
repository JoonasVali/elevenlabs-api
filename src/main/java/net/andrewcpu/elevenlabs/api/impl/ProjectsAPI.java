package net.andrewcpu.elevenlabs.api.impl;

import net.andrewcpu.elevenlabs.api.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.model.projects.Chapter;
import net.andrewcpu.elevenlabs.model.projects.ChapterSnapshot;
import net.andrewcpu.elevenlabs.model.projects.Project;
import net.andrewcpu.elevenlabs.model.projects.ProjectSnapshot;
import net.andrewcpu.elevenlabs.model.request.AddProjectRequest;
import net.andrewcpu.elevenlabs.requests.projects.*;

import java.io.InputStream;
import java.util.List;

public class ProjectsAPI extends ElevenLabsAPI {
	public List<Project> getProjects() {
		return sendRequest(new GetProjectsRequest()).getResult().getProjects();
	}

	public Project addProject(AddProjectRequest addProjectRequest) {
		return sendRequest(new PostAddProjectRequest(addProjectRequest)).getResult().getProject();
	}

	public Project getProject(String id) {
		return sendRequest(new GetProjectByIdRequest(id)).getResult();
	}

	public String deleteProject(String projectId) {
		return sendRequest(new DeleteProjectByIdRequest(projectId)).getResult();
	}

	public String convertProject(String projectId) {
		return sendRequest(new PostConvertProjectRequest(projectId)).getResult();
	}

	public List<ProjectSnapshot> getProjectSnapshots(String projectId) {
		return sendRequest(new GetProjectSnapshotsRequest(projectId)).getResult().getSnapshots();
	}

	public InputStream getProjectSnapshotAudioStream(String projectId, String projectSnapshotId) {
		return sendRequest(new PostStreamProjectSnapshotAudioRequest(projectId, projectSnapshotId)).getResult();
	}

	public List<Chapter> getChapters(String projectId) {
		return sendRequest(new GetProjectChaptersRequest(projectId)).getResult().getChapters();
	}

	public Chapter getChapterById(String projectId, String chapterId) {
		return sendRequest(new GetChapterByIdRequest(projectId, chapterId)).getResult();
	}

	public String deleteChapter(String projectId, String chapterId) {
		return sendRequest(new DeleteChapterByIdRequest(projectId, chapterId)).getResult();
	}

	public String convertChapter(String projectId, String chapterId) {
		return sendRequest(new PostConvertChapterRequest(projectId, chapterId)).getResult();
	}

	public List<ChapterSnapshot> getChapterSnapshots(String projectId, String chapterId) {
		return sendRequest(new GetChapterSnapshotsRequest(projectId, chapterId)).getResult().getSnapshots();
	}

	public InputStream getChapterSnapshotAudioStream(String projectId, String chapterId, String chapterSnapshotId) {
		return sendRequest(new PostStreamChapterSnapshotAudioRequest(projectId, chapterId, chapterSnapshotId)).getResult();
	}

}
