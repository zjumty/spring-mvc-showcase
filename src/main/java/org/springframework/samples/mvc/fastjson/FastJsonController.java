package org.springframework.samples.mvc.fastjson;

import com.alibaba.fastjson.JSONObject;
import org.springframework.samples.mvc.data.custom.RequestAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class FastJsonController {

    @RequestMapping(value = "/fastjson1", method = RequestMethod.POST)
    public @ResponseBody JSONObject fastjson1(@FastJson JSONObjectWrapper object) {
        for (Map.Entry<String, Object> entry : object.getJSONObject().entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        return object.getJSONObject();
    }


    @RequestMapping(value = "/fastjson2", method = RequestMethod.POST)
    public @ResponseBody FooBean fastjson2(@FastJson FooBean foo) {
        System.out.println(foo);
        return foo;
    }
}
