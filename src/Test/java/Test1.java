import com.pb.dao.BookDao;
import com.pb.dao.impl.BookDaoImpl;
import com.pb.entity.Book;
import com.pb.web.CriteriaBook;
import org.junit.Test;

/**
 * @author haohan
 * 12/12/2018 - 09:42 上午
 */
public class Test1 {

    BookDao bd = new BookDaoImpl();

    @Test
    public void test1() {
        Book book = bd.getBook(1);
        System.out.println(book);
    }

    @Test
    public void test2() {
        CriteriaBook cb = new CriteriaBook();
        long totalBookNumber = bd.getTotalBookNumber(cb);
        System.out.println(totalBookNumber);
    }

    @Test
    public void test3() {

    }

    @Test
    public void test4() {
        int storeNumber = bd.getStoreNumber(1);
        System.out.println(storeNumber);
    }

}
