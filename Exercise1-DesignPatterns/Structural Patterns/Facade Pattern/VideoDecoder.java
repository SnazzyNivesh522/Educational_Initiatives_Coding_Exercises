public class VideoDecoder {
    public void decode(VideoFile file,Codec codec) {
        System.out.println("Decoding " + file.getFileName() + " using " + codec.getCodecType() + " codec.");
    }
}
