
// 

/*
 *  here i will use Observer design pattern for getting video segments.
 *  
 *  Play: As VideoPlayer is subscribed to VideoDownloader. When a segment is download,
 *  
 *  VideoDownloader notifies VideoPlayer and that segment is played. Otherwise after timeout buffering indicator
 *  will be shown
 *  
 *  forward: When user tap forward, it forwards to next tenth frame.
 *  
 *  and rewind: When user tap rewind, it starts with first frame.
 */


package video_player;
import java.util.ArrayList;
import java.util.List;


public class player {
	
		private List<VideoSegment> videoSegmentList = new ArrayList<>();
		
		public static void main(String[] args) {
		
			player videoPlayer = new player();
			
			VideoDownloader videoDownloader = new VideoDownloader();
			
			
			videoPlayer.play();
		}

		private void showBufferingIndicator() {
			
			System.out.println("Showing buffering indicator");
		}
		
		private void playVideoSegment() {
			//Playing video segment
		}
		
		private void playVideoSegmentToSpecificPosition(int offset) {
			//Playing video segment
		}
		
		public void play() {
			try {
				wait(3000);
				showBufferingIndicator();
			} 
			 catch (InterruptedException e) {
				playVideoSegment();
			}
		}
		
		public void forward() {
			playVideoSegmentToSpecificPosition(5);
		}
		
		public void rewind() {
			playVideoSegmentToSpecificPosition(0);
		}

	
	}

	class VideoSegment {
		byte []payload;
		boolean isLastSegment;
	}

	class VideoDownloader {
		private OnVideoSegmentReceivedListener onVideoSegmentReceivedListener; 
		
		public VideoDownloader() {
		}
		
		public void download() {
			// download asynchronously
			boolean shouldDownloadVideo = true;
			while (shouldDownloadVideo) {
				
				// Downloading and creating video segment
				VideoSegment videoSegment = new VideoSegment(); 
				shouldDownloadVideo = !videoSegment.isLastSegment;
				onVideoSegmentReceivedListener.notifyVideoPlayer(videoSegment);
			}
		}
		
		public void subScribe(player videoPlayer) {
			if (videoPlayer instanceof OnVideoSegmentReceivedListener) {
				onVideoSegmentReceivedListener = (OnVideoSegmentReceivedListener) videoPlayer;
			} else {
				throw new ClassCastException("VideoPlayer should implement OnVideoSegmentReceivedListener.");
			}
		}
		
	}


	interface OnVideoSegmentReceivedListener {
		void notifyVideoPlayer(VideoSegment videoSegment);
	}


