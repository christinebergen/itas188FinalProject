package edu.itas.christine.bergen.lastproject188;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;


public class FifthActivity extends AppCompatActivity {

    private VideoView videoView;
    private Button button4, shareButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1970);


        videoView = findViewById(R.id.videoView);
        button4 = findViewById(R.id.button4);
        shareButton = findViewById(R.id.shareButton);

        // Video URL to play. In future, I'd like to not have the videos hard coded in, instead accessing and the names
        // from google the cloud storage file names.
        final String videoUrl4 = "https://storage.googleapis.com/bergson_home_videos/oldMovie1.mp4";

        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoView.isPlaying()) {
                    videoView.pause();
                } else {
                    videoView.start();
                }
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo(videoUrl4);
            }
        });

        // Function to share video URL in text message which accesses contacts within the phone.
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlToShare = "https://storage.googleapis.com/bergson_home_videos/oldMovie1.mp4";
                String messageToShare = "Check out this video I think you'd like! " + urlToShare;
                Intent shareIntent = new Intent(Intent.ACTION_SENDTO);
                shareIntent.setData(Uri.parse("smsto:")); // Only show messaging apps
                shareIntent.putExtra("sms_body", messageToShare); // Pre-fill the message body
                startActivity(shareIntent);
            }

        });
    }
    // Play video code obtained from  https://www.geeksforgeeks.org/how-to-play-video-from-url-in-android/
    // with some assistance from chatGPT for the code to only play videos while on WIFI.
        private void playVideo (String videoUrl){
            // finding videoview by its id
            VideoView videoView = findViewById(R.id.videoView);

            // creating object of
            // media controller class
            MediaController mediaController = new MediaController(this);

            // sets the anchor view
            // anchor view for the videoView
            mediaController.setAnchorView(videoView);

            // sets the media player to the videoView
            mediaController.setMediaPlayer(videoView);

            // sets the media controller to the videoView
            videoView.setMediaController(mediaController);


            // checking if the device is connected to Wi-Fi
            ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkCapabilities capabilities = connManager.getNetworkCapabilities(connManager.getActiveNetwork());

            if (capabilities != null && capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                // Connected to Wi-Fi, allow the video to play


                // Uri object to refer the
                // resource from the videoUrl
                Uri uri = Uri.parse(videoUrl);

                // sets the resource from the
                // videoUrl to the videoView
                videoView.setVideoURI(uri);

                // starts the video
                videoView.start();
            } else {
                // Not connected to Wi-Fi, show an error message
                Toast.makeText(this, "Please connect to Wi-Fi to watch the video", Toast.LENGTH_LONG).show();
            }

        }


    public void goHome(View view) {
        startActivity(new Intent(FifthActivity.this, HomeActivity.class));
    }
}