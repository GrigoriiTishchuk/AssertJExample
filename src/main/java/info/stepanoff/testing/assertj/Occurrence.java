
package info.stepanoff.testing.assertj;

import com.google.common.primitives.Ints;


public class Occurrence implements Comparable<Occurrence> {

    public final int begin;
    public final int end;
    public final int patternIndex;

    public Occurrence(int begin, int end, int patternIndex) {
        this.begin = begin;
        this.end = end;
        this.patternIndex = patternIndex;
    }

    @Override
    public int compareTo(Occurrence o) {
        int c = Ints.compare(begin, o.begin);
        if (c != 0) {
            return c;
        }
        c = Ints.compare(end, o.end);
        if (c != 0) {
            return c;
        }
        return Ints.compare(patternIndex, o.patternIndex);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.begin;
        hash = 97 * hash + this.end;
        hash = 97 * hash + this.patternIndex;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Occurrence other = (Occurrence) obj;
        if (this.begin != other.begin) {
            return false;
        }
        if (this.end != other.end) {
            return false;
        }
        if (this.patternIndex != other.patternIndex) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "(" + begin + ", " + end + ", " + patternIndex + ")";
    }
}
