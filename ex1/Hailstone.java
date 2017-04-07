package ex1;

import java.util.Iterator;
import java.util.NoSuchElementException;
	
public class Hailstone implements Iterable<Integer> {

    private Integer start;

    public Hailstone(Integer start) {
        this.start = start;
    }

    public Iterator<Integer> iterator() {
        return new HailstoneIterator();
    }

    private static Integer calc(Integer a) {
        if (a == null) {
            return null;
        }
        else if(a % 2 == 0){
        	return (a / 2); 
        }
        else 
        return ((3 * a) + 1);
}
    private class HailstoneIterator implements Iterator<Integer> {
    	
    	private Boolean appear = false;
        private Integer tag;
      

        public HailstoneIterator() {
            tag = Hailstone.this.start;
        }

        public boolean hasNext() {
        	if((this.appear==false)&&(this.tag != null)){
            return true ;
        	}
        	else 
        		return false;
        }

        public Integer next() {
            if (this.hasNext()) {
            
                if (this.tag == 1) {
                    this.appear = true;
                }
                int valc = this.tag;
                if (this.appear==false) {
                    this.tag = Hailstone.calc(this.tag);
                }
          	  
                return valc;
            }
            throw new NoSuchElementException();

        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

}