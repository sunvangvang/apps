package com.aibyd.apps.core.util;

import com.alibaba.fastjson.JSONObject;

/**
 * 响应操作结果
 * 
 * <pre>
 *  {
 *      state: 响应码
 *      msg: 相应信息
 *      res: 响应数据
 *  }
 * </pre>
 * 
 * <p>
 * 响应码:
 * <ul>
 * <li>0: 成功</li>
 * <li>4xx: 前端错误, 说明前端开发者需要重新了解后端接口使用规范</li>
 * <ul>
 * <li>401: 参数错误, 即前端没有传递后端需要的参数</li>
 * <li>402: 参数值错误, 即前端传递的参数值不符合后端接收范围</li>
 * </ul>
 * <li>5xx: 后端错误, 除501外, 说明后端开发者应该继续优化代码, 尽量避免返回后端错误码</li>
 * <ul>
 * <li>501: 验证失败, 即后端要求用户登录</li>
 * <li>502: 系统内部错误, 即没有合适命名的后端内部错误</li>
 * <li>503: 业务不支持, 即后端虽然定义了接口, 但是还没有实现功能</li>
 * <li>504: 更新数据失败, 即后端采用了乐观锁更新, 而并发更新时存在数据更新失效</li>
 * <li>505: 更新数据失败, 即后端数据库更新失败(正常情况应该更新成功)</li>
 * </ul>
 * <li>6xx: 后端业务错误码</li>
 * <li>7xx: 后端业务错误码</li>
 * </ul>
 * </p>
 */
public class ResponseUtil {

    public static JSONObject ok() {
        // Map<String, Object> obj = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        obj.put("state", 0);
        obj.put("msg", "成功");
        return obj;
    }

    public static JSONObject ok(Object res) {
        // Map<String, Object> obj = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        obj.put("state", 0);
        obj.put("msg", "成功");
        obj.put("res", res);
        return obj;
    }

    public static JSONObject ok(String msg, Object res) {
        // Map<String, Object> obj = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        obj.put("state", 0);
        obj.put("msg", msg);
        obj.put("res", res);
        return obj;
    }

    public static JSONObject fail() {
        // Map<String, Object> obj = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        obj.put("state", -1);
        obj.put("msg", "错误");
        return obj;
    }

    public static JSONObject fail(int errno, String errmsg) {
        // Map<String, Object> obj = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        obj.put("state", errno);
        obj.put("msg", errmsg);
        return obj;
    }

    public static JSONObject badArgument() {
        return fail(401, "参数不对");
    }

    public static JSONObject badArgumentValue() {
        return fail(402, "参数值不对");
    }

    public static JSONObject unlogin() {
        return fail(501, "请登录");
    }

    public static JSONObject serious() {
        return fail(502, "系统内部错误");
    }

    public static JSONObject unsupport() {
        return fail(503, "业务不支持");
    }

    public static JSONObject updatedDataExpired() {
        return fail(504, "更新数据已经失效");
    }

    public static Object updatedDataFailed() {
        return fail(505, "更新数据失败");
    }

}