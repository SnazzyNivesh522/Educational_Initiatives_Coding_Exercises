public class CodecFactory {
    public static Codec extract(VideoFile file) {
        String fileName=file.getFileName();
        if(fileName.endsWith(".mp4")){
            System.out.println("Extracting MP4 codec.");
            return new MP4Codec();
        }
        else if(fileName.endsWith(".avi"))
        {
            System.out.println("Extracting AVI codec.");
            return new AVICodec();
        }
        throw new IllegalArgumentException("Unsupported file format");
            
    }
}
