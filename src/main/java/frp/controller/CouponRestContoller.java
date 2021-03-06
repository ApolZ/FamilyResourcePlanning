package frp.controller;

import frp.entity.Coupon;
import frp.helper.StyleHelper;
import frp.model.ModalResponse;
import frp.respository.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ModalResponse use(@RequestBody Coupon input) {
        Integer ownerId = input.getId();
        Coupon persisted = couponRepo.findOne(ownerId);
        persisted.setState(0);
        persisted.setUsedDate(new Date());
        couponRepo.save(persisted);
        return new ModalResponse("核销成功", StyleHelper.ownerNameById(ownerId)+"使用掉了一张《"+ persisted.getName()+ "》，再没有了！", 200);
    }

    @RequestMapping(value = "/coupon/create/", method = RequestMethod.POST)
    public ModalResponse create(@RequestBody Coupon input) {
        input.setState(1);
        input.setCreatedDate(new Date());
        couponRepo.save(input);
        return new ModalResponse("新增成功", StyleHelper.ownerNameById(input.getOwnerId())+"获得了一张崭新的《"+ input.getName()+ "》！", 200);
    }

    @RequestMapping(value = "/coupon/createAs/", method = RequestMethod.POST)
    public ModalResponse createAs(@RequestBody Coupon input) {
        Integer inputId = input.getId();
        Coupon oldCoupon = couponRepo.findOne(inputId);
        Coupon newCoupon = new Coupon();
        newCoupon.setCreatedDate(new Date());
        newCoupon.setState(1);
        newCoupon.setName(oldCoupon.getName());
        newCoupon.setDescription(oldCoupon.getDescription());
        newCoupon.setOwnerId(oldCoupon.getOwnerId());
        newCoupon.setType(oldCoupon.getType());
        couponRepo.save(newCoupon);
        return new ModalResponse("耶！再来一张！", StyleHelper.ownerNameById(oldCoupon.getOwnerId())+"又获得了一张新的《"+ oldCoupon.getName()+ "》！", 200);
    }
}
