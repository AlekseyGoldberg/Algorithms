package Lab12;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CircleBuffer<T> {
    private byte[] massOfByte;
    private int freeIndex;

    public CircleBuffer() {
        freeIndex = 0;
        massOfByte = new byte[12];
    }

    public CircleBuffer(int size) {
        freeIndex = 0;
        massOfByte = new byte[size];
    }

    public void add(T element) {
        byte[] newByteMass = element.toString().getBytes(StandardCharsets.UTF_8);
        for (int j = 0; j < newByteMass.length; j++) {
            if (freeIndex == massOfByte.length) {
                freeIndex = 0;
            }
            massOfByte[freeIndex] = newByteMass[j];
            freeIndex++;
        }
    }

    public void print() {
        System.out.println(Arrays.toString(massOfByte));
    }
}
