public class VideoEncoder {
    public void encode(VideoFile file,Codec codec) {
        System.out.println("Encoding " + file.getFileName() + " using " + codec.getCodecType() + " codec.");
    }
}
