package sorting;

public class EntryLong implements Comparable<EntryLong> {
    private final long number;
    private final long freq;

    EntryLong(long n, long f) {
        this.number = n;
        this.freq = f;
    }

    public long getFreq() {
        return freq;
    }

    public long getNumber() {
        return number;
    }

    @Override
    public int compareTo(EntryLong entry) {
        long n = number;
        long f = freq;
        long tempN = entry.getNumber();
        long tempF = entry.getFreq();
        if (n > tempN && tempF == f) {
            return 1;
        }
        if (n < tempN && tempF == f) {
            return -1;
        }
        return Long.compare(f, tempF);
    }
}
