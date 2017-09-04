package frp.respository;

import frp.entity.Coupon;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZhuHanxi
 * @Date 03/09/2017
 */
@Repository
public interface CouponRepo extends CrudRepository<Coupon, Integer> {

    @Query(value = "select coupon from Coupon coupon")
    List<Coupon> list();

}
