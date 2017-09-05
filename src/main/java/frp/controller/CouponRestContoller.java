package frp.controller;

import frp.entity.Coupon;
import frp.respository.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhuHanxi
 * @Date 04/09/2017
 */
@RestController
public class CouponRestContoller {

    @Autowired
    private CouponRepo couponRepo;

    @RequestMapping(value = "/coupon/use/", method = RequestMethod.POST)
    public String detail(@RequestBody Coupon input) {
        Coupon persisted = couponRepo.findOne(input.getId());
        persisted.setState(0);
        couponRepo.save(persisted);
        return "echo";
    }

}
