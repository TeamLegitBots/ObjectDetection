
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class OpencvTest {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("Hello OpenCV version is " + Core.VERSION);
        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println("mat = " + mat.dump());
        
        detectLena();
    }

    private static void detectLena() {
        System.out.println("\nRunning DetectFaceDemo");
        // Create a face detector from the cascade file in the resources
        // directory.
        CascadeClassifier faceDetector = new CascadeClassifier("C:\\tmp\\lbpcascade_frontalface.xml");
        //Mat image = Imgcodecs.imread("C:\\tmp\\lena.png");
        Mat image = Imgcodecs.imread("C:\\tmp\\legit.jpg");

        //System.out.println(image.dump());
        // Detect faces in the image.
        // MatOfRect is a special container class for Rect.
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);
        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
        // Draw a bounding box around each face.

        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(image,new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
        }

        // Save the visualized detection.
        String filename = "C:\\tmp\\faceDetection.png";
        System.out.println(String.format("Writing %s", filename));
        Imgcodecs.imwrite(filename, image);
        
    }

}
