package frp.controller;

import frp.entity.Coupon;
import frp.respository.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ZhuHanxi
 * @Date 03/09/2017
 */
@Controller
@RequestMapping("")
public class CouponController {

    @Autowired
    private CouponRepo couponRepo;

    @RequestMapping("/")
    public String list(Model model) {
        model.addAttribute("list",couponRepo.list());
        return "coupon/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String detail(Model model, Coupon coupon) {
        model.addAttribute("list",couponRepo.save(coupon));
        return "coupon/detail";
    }
}
