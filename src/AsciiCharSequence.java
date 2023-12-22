public class AsciiCharSequence implements CharSequence {
    public static void main(String[] args) {
        byte[] byteArray = {65, 66, 67, 68, 69};
        AsciiCharSequence charSequence = new AsciiCharSequence(byteArray);

        System.out.println("Length: " + charSequence.length());
        System.out.println("Char at index 2: " + charSequence.charAt(2));
        System.out.println("Subsequence from 1 to 4: " + charSequence.subSequence(1, 4));
        System.out.println("ToString: " + charSequence.toString());
    }
    private byte[] content;

    public AsciiCharSequence(byte[] content) {
        this.content = content;
    }

    @Override
    public int length() {
        return content.length;
    }

    @Override
    public char charAt(int index) {
        return (char)content[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] result = new byte[end-start];
        for(int i = start; i < end; i++){
            result[i-start] = content[i];
        }
        return new AsciiCharSequence(result);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(content.length);
        for(int i = 0; i < content.length; i++ ){
            result.append((char)content[i]);
        }
        return result.toString();
    }
}
