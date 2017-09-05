package frp.controller;

import frp.entity.Coupon;
import frp.respository.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ZhuHanxi
 * @Date 04/09/2017
 */
@RestController
public class CouponRestContoller {

    @Autowired
    private CouponRepo couponRepo;

    @RequestMapping(value = "/coupon/use/", method = RequestMethod.POST)
    public String use(@RequestBody Coupon input) {
        Coupon persisted = couponRepo.findOne(input.getId());
        persisted.setState(0);
        persisted.setUsedDate(new Date());
        couponRepo.save(persisted);
        return "echo";
    }

    @RequestMapping(value = "/coupon/create/", method = RequestMethod.POST)
    public String create(@RequestBody Coupon input) {
        input.setState(1);
        input.setCreatedDate(new Date());
        couponRepo.save(input);
        return "echo";
    }
}
