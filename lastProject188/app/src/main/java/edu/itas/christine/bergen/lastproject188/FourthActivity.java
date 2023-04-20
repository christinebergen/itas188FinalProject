package edu.itas.christine.bergen.lastproject188;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;

import android.widget.Toast;
import android.widget.VideoView;

public class FourthActivity extends AppCompatActivity {

    private VideoView videoView;
    private Button button1, button2, button3, button4, shareButton1, shareButton2, shareButton3, shareButton4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1980);

        videoView = findViewById(R.id.videoView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        shareButton1 = findViewById(R.id.shareButton1);
        shareButton2 = findViewById(R.id.shareButton2);
        shareButton3 = findViewById(R.id.shareButton3);
        shareButton4 = findViewById(R.id.shareButton4);


        // Video URLs to play. In future, I'd like to not have the videos hard coded in, instead accessing and the names
        // from google the cloud storage file names.

        final String videoUrl1 = "https://storage.googleapis.com/bergson_home_videos/disney1.mp4";
        final String videoUrl2 = "https://storage.googleapis.com/bergson_home_videos/disney2.mp4";
        final String videoUrl3 = "https://storage.googleapis.com/bergson_home_videos/disney3.mp4";
        final String videoUrl4 = "https://storage.googleapis.com/bergson_home_videos/disney4.mp4";

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


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo(videoUrl1);
            }
        });

        // function to share video URL via text message by accessing phone contacts.
        // Assistance for this function from ChatGPT
        shareButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlToShare = (videoUrl1);
                String messageToShare = "Check out this video I think you'd like from Wilson Family Home Movies! " + urlToShare;
                Intent shareIntent = new Intent(Intent.ACTION_SENDTO);
                shareIntent.setData(Uri.parse("smsto:")); // Only show messaging apps
                shareIntent.putExtra("sms_body", messageToShare); // Pre-fill the message body
                startActivity(shareIntent);
            }

        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo(videoUrl2);
            }
        });

        // function to share video URL via text message by accessing phone contacts.
        // Assistance for this function from ChatGPT
        shareButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlToShare = (videoUrl2);
                String messageToShare = "Check out this video I think you'd like from Wilson Family Home Movies! " + urlToShare;
                Intent shareIntent = new Intent(Intent.ACTION_SENDTO);
                shareIntent.setData(Uri.parse("smsto:")); // Only show messaging apps
                shareIntent.putExtra("sms_body", messageToShare); // Pre-fill the message body
                startActivity(shareIntent);
            }

        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo(videoUrl3);
            }

        });

        // function to share video URL via text message by accessing phone contacts.
        // Assistance for this function from ChatGPT
        shareButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlToShare = (videoUrl3);
                String messageToShare = "Check out this video I think you'd like from Wilson Family Home Movies! " + urlToShare;
                Intent shareIntent = new Intent(Intent.ACTION_SENDTO);
                shareIntent.setData(Uri.parse("smsto:")); // Only show messaging apps
                shareIntent.putExtra("sms_body", messageToShare); // Pre-fill the message body
                startActivity(shareIntent);
            }

        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo(videoUrl4);
            }
        });

        // function to share video URL via text message by accessing phone contacts.
        // Assistance for this function from ChatGPT
        shareButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlToShare = (videoUrl4);
                String messageToShare = "Check out this video I think you'd like from Wilson Family Home Movies! " + urlToShare;
                Intent shareIntent = new Intent(Intent.ACTION_SENDTO);
                shareIntent.setData(Uri.parse("smsto:")); // Only show messaging apps
                shareIntent.putExtra("sms_body", messageToShare); // Pre-fill the message body
                startActivity(shareIntent);
            }

        });
    }

    // Play video code obtained from  https://www.geeksforgeeks.org/how-to-play-video-from-url-in-android/
    // with some assistance from chatGPT for the code to only play videos while on WIFI.
    private void playVideo(String videoUrl) {

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
    // go to home page
    public void goHome(View view) {
        startActivity(new Intent(FourthActivity.this, HomeActivity.class));
    }
}
