import java.util.*;

class AsciiCharSequence implements CharSequence {
    // implementation
    byte[] array;

    public AsciiCharSequence(byte[] array) {
        this.array = array;
    }

    @Override
    public int length() {
        return this.array.length;
    }

    @Override
    public char charAt(int index) {
        return (char) this.array[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(this.array, start, end));
    }

    @Override
    public String toString() {
        return new String(this.array);
    }
}