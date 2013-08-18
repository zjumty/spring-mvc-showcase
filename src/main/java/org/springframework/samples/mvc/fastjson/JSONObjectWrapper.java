package org.springframework.samples.mvc.fastjson;

import com.alibaba.fastjson.JSONObject;

/**
 * User: matianyi
 * Date: 13-8-18
 * Time: 下午11:34
 */
public class JSONObjectWrapper {
    private JSONObject jsonObject;

    public JSONObjectWrapper(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public JSONObject getJSONObject() {
        return jsonObject;
    }
}
