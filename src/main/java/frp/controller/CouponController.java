package frp.controller;

import frp.entity.Coupon;
import frp.helper.StyleHelper;
import frp.respository.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("subTitle","查看所有的券");
        return "coupon/list";
    }

    @RequestMapping("/{ownerId}/")
    public String view(Model model, @PathVariable(value = "ownerId") Integer ownerId) {
        model.addAttribute("list",couponRepo.findByOwnerId(ownerId));
        model.addAttribute("subTitle", StyleHelper.ownerNameById(ownerId)+"的券");
        return "coupon/list";
    }

    @RequestMapping("/create")
    public String create() {
        return "coupon/create";
    }
}
