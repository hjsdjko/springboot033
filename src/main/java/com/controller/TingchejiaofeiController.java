package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.TingchejiaofeiEntity;
import com.entity.view.TingchejiaofeiView;

import com.service.TingchejiaofeiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayApiException;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.config.AlipayConfig;

/**
 * 停车缴费
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-23 23:12:44
 */
@RestController
@RequestMapping("/tingchejiaofei")
public class TingchejiaofeiController {
    @Autowired
    private TingchejiaofeiService tingchejiaofeiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TingchejiaofeiEntity tingchejiaofei,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			tingchejiaofei.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TingchejiaofeiEntity> ew = new EntityWrapper<TingchejiaofeiEntity>();

		PageUtils page = tingchejiaofeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tingchejiaofei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TingchejiaofeiEntity tingchejiaofei, 
		HttpServletRequest request){
        EntityWrapper<TingchejiaofeiEntity> ew = new EntityWrapper<TingchejiaofeiEntity>();

		PageUtils page = tingchejiaofeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tingchejiaofei), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TingchejiaofeiEntity tingchejiaofei){
       	EntityWrapper<TingchejiaofeiEntity> ew = new EntityWrapper<TingchejiaofeiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tingchejiaofei, "tingchejiaofei")); 
        return R.ok().put("data", tingchejiaofeiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TingchejiaofeiEntity tingchejiaofei){
        EntityWrapper< TingchejiaofeiEntity> ew = new EntityWrapper< TingchejiaofeiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tingchejiaofei, "tingchejiaofei")); 
		TingchejiaofeiView tingchejiaofeiView =  tingchejiaofeiService.selectView(ew);
		return R.ok("查询停车缴费成功").put("data", tingchejiaofeiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TingchejiaofeiEntity tingchejiaofei = tingchejiaofeiService.selectById(id);
        return R.ok().put("data", tingchejiaofei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TingchejiaofeiEntity tingchejiaofei = tingchejiaofeiService.selectById(id);
        return R.ok().put("data", tingchejiaofei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TingchejiaofeiEntity tingchejiaofei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(tingchejiaofei);
        tingchejiaofeiService.insert(tingchejiaofei);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TingchejiaofeiEntity tingchejiaofei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(tingchejiaofei);
        tingchejiaofeiService.insert(tingchejiaofei);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TingchejiaofeiEntity tingchejiaofei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tingchejiaofei);
        tingchejiaofeiService.updateById(tingchejiaofei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tingchejiaofeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	




    @RequestMapping("/alipay")
    public R payController(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) Integer isFront) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        if(isFront!=null && isFront==1) {
            alipayRequest.setReturnUrl(AlipayConfig.return_url_f+"index/tingchejiaofei?centerType=1");
        } else {
            alipayRequest.setReturnUrl(AlipayConfig.return_url_b+"tingchejiaofei");
        }
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url+"tingchejiaofei"+"/notify");

        String out_trade_no = new String(request.getParameter("tradeno"));
        String total_amount = new String(request.getParameter("totalamount").getBytes("ISO-8859-1"),"UTF-8");
        String subject = new String(request.getParameter("subject"));
        String body = "";

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return R.ok().put("data",form);
    }

    @IgnoreAuth
    @RequestMapping("notify")
    public R nofity(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /* *
         * 功能：支付宝服务器异步通知页面
         *************************页面功能说明*************************
         * 创建该页面文件时，请留心该页面文件中无任何HTML代码及空格。
         * 该页面不能在本机电脑测试，请到服务器上做测试。请确保外部可以访问该页面。
         * 如果没有收到该页面返回的 success
         * 建议该页面只做支付成功的业务逻辑处理，退款的处理请以调用退款查询接口的结果为准。
         */

            //获取支付宝POST过来反馈信息
            Map<String,String> params = new HashMap<String,String>();
            Map<String,String[]> requestParams = request.getParameterMap();
            for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
                }
                //乱码解决，这段代码在出现乱码时使用
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
                params.put(name, valueStr);
            }

            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

            if(trade_status.equals("TRADE_FINISHED")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
            }else if (trade_status.equals("TRADE_SUCCESS")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //付款完成后，支付宝系统发送该交易状态通知
                TingchejiaofeiEntity tingchejiaofei = tingchejiaofeiService.selectOne(new EntityWrapper<TingchejiaofeiEntity>().eq("dingdanhao", out_trade_no));
                if(tingchejiaofei!=null) {
                    tingchejiaofei.setIspay("已支付");
                    tingchejiaofeiService.updateById(tingchejiaofei);
                }
            }

            //——请在这里编写您的程序（以上代码仅作参考）——
            return R.ok();
    }


    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<TingchejiaofeiEntity> ew = new EntityWrapper<TingchejiaofeiEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = tingchejiaofeiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<TingchejiaofeiEntity> ew = new EntityWrapper<TingchejiaofeiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = tingchejiaofeiService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<TingchejiaofeiEntity> ew = new EntityWrapper<TingchejiaofeiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = tingchejiaofeiService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<TingchejiaofeiEntity> ew = new EntityWrapper<TingchejiaofeiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = tingchejiaofeiService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<TingchejiaofeiEntity> ew = new EntityWrapper<TingchejiaofeiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = tingchejiaofeiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,TingchejiaofeiEntity tingchejiaofei, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            tingchejiaofei.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<TingchejiaofeiEntity> ew = new EntityWrapper<TingchejiaofeiEntity>();
        int count = tingchejiaofeiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tingchejiaofei), params), params));
        return R.ok().put("data", count);
    }



}
