package sorting;

public class EntryWordAndLine implements Comparable<EntryWordAndLine> {
    private final String word;
    private final long freq;

    EntryWordAndLine(String word, long freq) {
        this.word = word;
        this.freq = freq;
    }

    public String getWord() {
        return word;
    }

    public long getFreq() {
        return freq;
    }

    @Override
    public int compareTo(EntryWordAndLine entry) {
        String w = word;
        long f = freq;
        String tempS = entry.getWord();
        long tempF = entry.getFreq();
        if (w.compareTo(tempS) > 0 && f == tempF) {
            return 1;
        }
        if (w.compareTo(tempS) < 0 && f == tempF) {
            return -1;
        }
        return Long.compare(f, tempF);

    }
}
