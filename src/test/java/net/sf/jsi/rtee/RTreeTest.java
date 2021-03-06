package net.sf.jsi.rtee;

import gnu.trove.procedure.TIntProcedure;
import net.sf.jsi.SpatialIndexFactory;
import net.sf.jsi.geometry.Point;
import net.sf.jsi.geometry.Rectangle;
import net.sf.jsi.rtree.RTree;
import org.junit.Test;

import java.util.Properties;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class RTreeTest {
    
    private Random r = new Random();

    @Test
    public void testMoveEntries() {
        testMoveEntries(4, 50, 4, 10);
    }

    @Test
    public void testDeleteAllEntries() {
        Rectangle[] rects = new Rectangle[500];

        for(int i = 0; i < rects.length; i++) {
            rects[i] = randomRectangle();
        }

        testDeleteAllEntries(1, 2, rects);
        testDeleteAllEntries(1, 3, rects);
        testDeleteAllEntries(2, 4, rects);
        testDeleteAllEntries(2, 5, rects);
        testDeleteAllEntries(2, 6, rects);
    }

    @Test
    public void testMaxValue() {
        RTree rTree = new RTree();
        rTree.init(null);
        rTree.add(new Rectangle(8.0f, 6.0f, Float.MAX_VALUE, Float.MAX_VALUE), 1);
        rTree.add(new Rectangle(1.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 2);
        rTree.add(new Rectangle(10.0f, 6.0f, Float.MAX_VALUE, Float.MAX_VALUE), 3);
        rTree.add(new Rectangle(5.0f, 8.0f, Float.MAX_VALUE, Float.MAX_VALUE), 4);
        rTree.add(new Rectangle(6.0f, 1.0f, Float.MAX_VALUE, Float.MAX_VALUE), 6);
        rTree.add(new Rectangle(3.0f, 1.0f, Float.MAX_VALUE, Float.MAX_VALUE), 7);
        rTree.add(new Rectangle(9.0f, 8.0f, Float.MAX_VALUE, Float.MAX_VALUE), 8);
        rTree.add(new Rectangle(5.0f, 7.0f, Float.MAX_VALUE, Float.MAX_VALUE), 9);
        rTree.add(new Rectangle(2.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 10);
        rTree.add(new Rectangle(2.0f, 2.0f, Float.MAX_VALUE, Float.MAX_VALUE), 11);
        rTree.add(new Rectangle(5.0f, 3.0f, Float.MAX_VALUE, Float.MAX_VALUE), 14);
        rTree.add(new Rectangle(7.0f, 3.0f, Float.MAX_VALUE, Float.MAX_VALUE), 15);
        rTree.add(new Rectangle(6.0f, 3.0f, Float.MAX_VALUE, Float.MAX_VALUE), 16);
        rTree.delete(new Rectangle(9.0f, 8.0f, Float.MAX_VALUE, Float.MAX_VALUE), 8);
        rTree.add(new Rectangle(7.0f, 8.0f, Float.MAX_VALUE, Float.MAX_VALUE), 17);
        rTree.add(new Rectangle(3.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 18);
        rTree.delete(new Rectangle(5.0f, 7.0f, Float.MAX_VALUE, Float.MAX_VALUE), 9);
        rTree.add(new Rectangle(4.0f, 7.0f, Float.MAX_VALUE, Float.MAX_VALUE), 19);
        rTree.delete(new Rectangle(2.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 10);
        rTree.add(new Rectangle(2.0f, 1.0f, Float.MAX_VALUE, Float.MAX_VALUE), 20);
        rTree.add(new Rectangle(9.0f, 6.0f, Float.MAX_VALUE, Float.MAX_VALUE), 21);
        rTree.add(new Rectangle(7.0f, 6.0f, Float.MAX_VALUE, Float.MAX_VALUE), 22);
        rTree.delete(new Rectangle(10.0f, 6.0f, Float.MAX_VALUE, Float.MAX_VALUE), 3);
        rTree.add(new Rectangle(3.0f, 4.0f, Float.MAX_VALUE, Float.MAX_VALUE), 23);
        rTree.delete(new Rectangle(3.0f, 1.0f, Float.MAX_VALUE, Float.MAX_VALUE), 7);
        rTree.add(new Rectangle(3.0f, 1.0f, Float.MAX_VALUE, Float.MAX_VALUE), 24);
        rTree.delete(new Rectangle(8.0f, 6.0f, Float.MAX_VALUE, Float.MAX_VALUE), 1);
        rTree.add(new Rectangle(3.0f, 6.0f, Float.MAX_VALUE, Float.MAX_VALUE), 25);
        rTree.delete(new Rectangle(7.0f, 8.0f, Float.MAX_VALUE, Float.MAX_VALUE), 17);
        rTree.add(new Rectangle(7.0f, 8.0f, Float.MAX_VALUE, Float.MAX_VALUE), 26);
        rTree.delete(new Rectangle(2.0f, 1.0f, Float.MAX_VALUE, Float.MAX_VALUE), 20);
        rTree.add(new Rectangle(0.0f, 1.0f, Float.MAX_VALUE, Float.MAX_VALUE), 27);
        rTree.delete(new Rectangle(2.0f, 2.0f, Float.MAX_VALUE, Float.MAX_VALUE), 11);
        rTree.add(new Rectangle(2.0f, 2.0f, Float.MAX_VALUE, Float.MAX_VALUE), 28);
        rTree.delete(new Rectangle(5.0f, 8.0f, Float.MAX_VALUE, Float.MAX_VALUE), 4);
        rTree.add(new Rectangle(4.0f, 2.0f, Float.MAX_VALUE, Float.MAX_VALUE), 29);
        rTree.delete(new Rectangle(5.0f, 3.0f, Float.MAX_VALUE, Float.MAX_VALUE), 14);
        rTree.add(new Rectangle(5.0f, 3.0f, Float.MAX_VALUE, Float.MAX_VALUE), 30);
        rTree.add(new Rectangle(7.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 31);
        rTree.delete(new Rectangle(7.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 31);
        rTree.add(new Rectangle(7.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 32);
        rTree.add(new Rectangle(5.0f, 8.0f, Float.MAX_VALUE, Float.MAX_VALUE), 33);
        rTree.delete(new Rectangle(2.0f, 2.0f, Float.MAX_VALUE, Float.MAX_VALUE), 28);
        rTree.add(new Rectangle(1.0f, 2.0f, Float.MAX_VALUE, Float.MAX_VALUE), 34);
        rTree.delete(new Rectangle(0.0f, 1.0f, Float.MAX_VALUE, Float.MAX_VALUE), 27);
        rTree.add(new Rectangle(0.0f, 1.0f, Float.MAX_VALUE, Float.MAX_VALUE), 35);
        rTree.add(new Rectangle(8.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 36);
        rTree.delete(new Rectangle(3.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 18);
        rTree.add(new Rectangle(3.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 37);
        rTree.add(new Rectangle(8.0f, 7.0f, Float.MAX_VALUE, Float.MAX_VALUE), 39);
        rTree.delete(new Rectangle(7.0f, 6.0f, Float.MAX_VALUE, Float.MAX_VALUE), 22);
        rTree.add(new Rectangle(5.0f, 2.0f, Float.MAX_VALUE, Float.MAX_VALUE), 40);
        rTree.delete(new Rectangle(3.0f, 1.0f, Float.MAX_VALUE, Float.MAX_VALUE), 24);
        rTree.add(new Rectangle(3.0f, 0.0f, Float.MAX_VALUE, Float.MAX_VALUE), 41);
        rTree.delete(new Rectangle(7.0f, 8.0f, Float.MAX_VALUE, Float.MAX_VALUE), 26);
        rTree.add(new Rectangle(7.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 42);
        rTree.delete(new Rectangle(7.0f, 3.0f, Float.MAX_VALUE, Float.MAX_VALUE), 15);
        rTree.add(new Rectangle(3.0f, 2.0f, Float.MAX_VALUE, Float.MAX_VALUE), 43);
        rTree.delete(new Rectangle(4.0f, 2.0f, Float.MAX_VALUE, Float.MAX_VALUE), 29);
        rTree.add(new Rectangle(4.0f, 2.0f, Float.MAX_VALUE, Float.MAX_VALUE), 44);
        rTree.delete(new Rectangle(3.0f, 6.0f, Float.MAX_VALUE, Float.MAX_VALUE), 25);
        rTree.add(new Rectangle(3.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 45);
        rTree.delete(new Rectangle(3.0f, 2.0f, Float.MAX_VALUE, Float.MAX_VALUE), 43);
        rTree.add(new Rectangle(1.0f, 0.0f, Float.MAX_VALUE, Float.MAX_VALUE), 46);
        rTree.delete(new Rectangle(1.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 2);
        rTree.add(new Rectangle(1.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 47);
        rTree.delete(new Rectangle(9.0f, 6.0f, Float.MAX_VALUE, Float.MAX_VALUE), 21);
        rTree.add(new Rectangle(7.0f, 6.0f, Float.MAX_VALUE, Float.MAX_VALUE), 48);
        rTree.delete(new Rectangle(4.0f, 7.0f, Float.MAX_VALUE, Float.MAX_VALUE), 19);
        rTree.add(new Rectangle(4.0f, 0.0f, Float.MAX_VALUE, Float.MAX_VALUE), 49);
        rTree.delete(new Rectangle(5.0f, 3.0f, Float.MAX_VALUE, Float.MAX_VALUE), 30);
        rTree.add(new Rectangle(0.0f, 2.0f, Float.MAX_VALUE, Float.MAX_VALUE), 50);
        rTree.delete(new Rectangle(5.0f, 8.0f, Float.MAX_VALUE, Float.MAX_VALUE), 33);
        rTree.add(new Rectangle(4.0f, 8.0f, Float.MAX_VALUE, Float.MAX_VALUE), 51);
        rTree.delete(new Rectangle(3.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 45);
        rTree.add(new Rectangle(3.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 52);
        rTree.delete(new Rectangle(7.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 42);
        rTree.add(new Rectangle(7.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 53);
        rTree.delete(new Rectangle(5.0f, 2.0f, Float.MAX_VALUE, Float.MAX_VALUE), 40);
        rTree.add(new Rectangle(3.0f, 2.0f, Float.MAX_VALUE, Float.MAX_VALUE), 54);
        rTree.delete(new Rectangle(6.0f, 1.0f, Float.MAX_VALUE, Float.MAX_VALUE), 6);
        rTree.add(new Rectangle(6.0f, 1.0f, Float.MAX_VALUE, Float.MAX_VALUE), 55);
        rTree.delete(new Rectangle(4.0f, 8.0f, Float.MAX_VALUE, Float.MAX_VALUE), 51);
        rTree.add(new Rectangle(4.0f, 8.0f, Float.MAX_VALUE, Float.MAX_VALUE), 56);
        rTree.delete(new Rectangle(1.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 47);
        rTree.add(new Rectangle(1.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 57);
        rTree.delete(new Rectangle(0.0f, 2.0f, Float.MAX_VALUE, Float.MAX_VALUE), 50);
        rTree.add(new Rectangle(0.0f, 2.0f, Float.MAX_VALUE, Float.MAX_VALUE), 58);
        rTree.delete(new Rectangle(3.0f, 0.0f, Float.MAX_VALUE, Float.MAX_VALUE), 41);
        rTree.add(new Rectangle(3.0f, 0.0f, Float.MAX_VALUE, Float.MAX_VALUE), 59);
        rTree.delete(new Rectangle(7.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 53);
        rTree.add(new Rectangle(0.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 60);
        rTree.delete(new Rectangle(6.0f, 1.0f, Float.MAX_VALUE, Float.MAX_VALUE), 55);
        rTree.add(new Rectangle(2.0f, 1.0f, Float.MAX_VALUE, Float.MAX_VALUE), 61);
        rTree.delete(new Rectangle(7.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 32);
        rTree.add(new Rectangle(0.0f, 5.0f, Float.MAX_VALUE, Float.MAX_VALUE), 62);
        rTree.delete(new Rectangle(0.0f, 2.0f, Float.MAX_VALUE, Float.MAX_VALUE), 58);
        rTree.add(new Rectangle(0.0f, 2.0f, Float.MAX_VALUE, Float.MAX_VALUE), 63);
        rTree.delete(new Rectangle(3.0f, 4.0f, Float.MAX_VALUE, Float.MAX_VALUE), 23);
        rTree.add(new Rectangle(3.0f, 3.0f, Float.MAX_VALUE, Float.MAX_VALUE), 64);
        rTree.delete(new Rectangle(8.0f, 7.0f, Float.MAX_VALUE, Float.MAX_VALUE), 39);
    }

    private Rectangle randomRectangle() {
        return new Rectangle(r.nextInt(100), r.nextInt(100), r.nextInt(100), r.nextInt(100));
    }

    private void testDeleteAllEntries(int minNodeEntries, int maxNodeEntries, Rectangle[] rects) {
        Properties p = new Properties();
        p.setProperty("MinNodeEntries", Integer.toString(minNodeEntries));
        p.setProperty("MaxNodeEntries", Integer.toString(maxNodeEntries));
        RTree rtree = (RTree) SpatialIndexFactory.newInstance("rtree.RTree", p);

        for (int i = 0; i <= rects.length; i+=100) {
            // add some entries
            for (int j = 0; j < i; j++) {
                rtree.add(rects[j], j);
            }
            assertTrue(rtree.checkConsistency());

            // now delete them all
            for (int j = 0; j < i; j++) {
                rtree.delete(rects[j], j);
            }
            assertTrue(rtree.size() == 0);
            assertTrue(rtree.checkConsistency());

            // check that we can make queries on an empty rtree without error.
            Rectangle testRect = new Rectangle(1,2,3,4);
            Point testPoint = new Point(1,2);

            Counter counter = new Counter();
            rtree.intersects(testRect, counter);
            assertTrue(counter.count == 0);

            rtree.nearest(testPoint, counter, Float.MAX_VALUE);
            assertTrue(counter.count == 0);

            rtree.nearestN(testPoint, counter, 10, Float.MAX_VALUE);
            assertTrue(counter.count == 0);

            rtree.nearestNUnsorted(testPoint, counter, 10, Float.MAX_VALUE);
            assertTrue(counter.count == 0);

            rtree.contains(testRect, counter);
            assertTrue(counter.count == 0);
        }
    }

    private void testMoveEntries(int minNodeEntries, int maxNodeEntries, int numRects, int numMoves) {

        Properties p = new Properties();
        p.setProperty("MinNodeEntries", Integer.toString(minNodeEntries));
        p.setProperty("MaxNodeEntries", Integer.toString(maxNodeEntries));
        RTree rtree = (RTree) SpatialIndexFactory.newInstance("rtree.RTree", p);

        Rectangle[] rects = new Rectangle[numRects];

        // first add the rects
        for (int i = 0; i < numRects; i++) {
            rects[i] = randomRectangle();
            rtree.add(rects[i], i);
        }

        // now move each one in turn
        for (int move = 0; move < numMoves; move++) {
            for (int i = 0; i < numRects; i++) {
                rtree.delete(rects[i], i);
                rects[i].set(randomRectangle());
                rtree.add(rects[i], i);
                assertTrue(rtree.checkConsistency());
            }
        }
    }

    private class Counter implements TIntProcedure {
        public int count = 0;
        public boolean execute(int arg0) {
            count++;
            return true;
        }
    };
}
