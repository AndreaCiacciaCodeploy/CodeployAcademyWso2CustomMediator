package com.corso.wso2.custom;

import org.apache.synapse.MessageContext;
import org.apache.synapse.mediators.AbstractMediator;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Wso2Esb custom mediator
 * 
 * @author andrea.ciaccia
 *
 */
public class MyCustomMediator extends AbstractMediator {

	public boolean mediate(MessageContext context) {
		String customMethod = (String) context.getProperty("custom_method");

		switch (customMethod) {
		case "SIMPLE":
			simpleTestMediation(context);
			break;
		case "STRINGIFY":
			stringify(context);
			break;

		}

		return true;
	}

	/**
	 * simple test mediation
	 * 
	 * @param context
	 */
	public static void simpleTestMediation(MessageContext context) {
		context.setProperty("my_mediation", "sono una semplice property del custom mediator");
	}

	/**
	 * valid mobile phone
	 * 
	 * @param phone
	 * @return
	 */
	public static void validMobilePhone(MessageContext context) {
		String phone = (String) context.getProperty("phone");
		String allCountryRegex = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";
		context.setProperty("valid_phone", phone.matches(allCountryRegex));
	}

	/**
	 * metodo che effettua lo stringify di un jsonstring
	 * 
	 * @param context
	 */
	public static void stringify(MessageContext context) {

		String payloadIn = (String) context.getProperty("payload_in");
		JSONParser parser = new JSONParser();
		Object obj = null;
		try {
			obj = parser.parse(payloadIn);
			org.json.simple.JSONObject jsonObj = (org.json.simple.JSONObject) obj;
			context.setProperty("payload_out", jsonObj.toJSONString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
