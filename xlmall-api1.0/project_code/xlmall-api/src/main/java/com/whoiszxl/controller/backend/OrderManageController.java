package com.whoiszxl.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import com.whoiszxl.common.ServerResponse;
import com.whoiszxl.service.OrderService;
import com.whoiszxl.service.UserService;
import com.whoiszxl.vo.OrderVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author whoiszxl
 *
 */
@Api(value = "后台订单模块", description = "后台订单模块")
@RestController
@RequestMapping("/manage/order")
public class OrderManageController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private OrderService orderService;

	@GetMapping("list")
	@ApiOperation(value = "后台订单列表")
	public ServerResponse<PageInfo> orderList(
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		return orderService.manageList(pageNum, pageSize);
	}

	@GetMapping("detail")
	@ApiOperation(value = "后台订单详情")
	public ServerResponse<OrderVo> orderDetail(Long orderNo) {
		return orderService.manageDetail(orderNo);

	}

	@GetMapping("search")
	@ApiOperation(value = "后台搜索订单")
	public ServerResponse<PageInfo> orderSearch(Long orderNo,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		return orderService.manageSearch(orderNo, pageNum, pageSize);
	}

	@PostMapping("send_goods")
	@ApiOperation(value = "后台订单发货")
	public ServerResponse<String> orderSendGoods(Long orderNo) {
		return orderService.manageSendGoods(orderNo);
	}
}
