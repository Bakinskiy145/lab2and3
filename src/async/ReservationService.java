package async;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.Endpoint;

@WebService(serviceName = "Reservation", portName = "ReservationPort", targetNamespace = "http://asu.dgtu.donetsk.ua/ex/students")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public class ReservationService {
	// store smartphone assortment
	private static Smartphone[] smartphoneData = {
			new Smartphone("1", "IPHONE", "13 PRO MAX", "red", 6, 512, 135999),
			new Smartphone("2", "POCO", "CLASS", "blue", 6, 128, 20720),
			new Smartphone("3", "SAMSUNG", "GALAXY S22", "violet", 8, 256, 68499),
			new Smartphone("4", "XIAOMI", "REDMI NOTE 10S", "black", 6, 128, 17499),
			new Smartphone("5,", "REALME ", "9 PRO+", "green", 8, 256, 35999)
	};
	// the number of products in the store
	private static int[] quantityData = {5, 5, 5, 5, 5};
	private static StoreAssortment storeAssortment = new StoreAssortment(smartphoneData, quantityData);
	private UserReserve goReserveSmartphone(String model, int quantity) {
		int size = storeAssortment.getSmartphones().length;
		for (int i = 0; i < size; i++) {
			Smartphone currentSmartphone = storeAssortment.getSmartphones()[i];
			int currentQuantity = storeAssortment.getQuantity()[i];
			if (model.equals(currentSmartphone.getModel()) && quantity <= currentQuantity) {
				storeAssortment.setQuantityFromIndex(i, currentQuantity - quantity);
				return new UserReserve(currentSmartphone, quantity);
			}
		}
		return null;
	}

	@WebMethod(operationName = "ReserveSmartphone")
	public UserReserve reserveSmartphone(String model, int quantity) {
		try {
			Thread.sleep(1000*10); // Sleep for 10 seconds
			return goReserveSmartphone(model, quantity);
		} catch(InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}

	 public static void main(String args[]) {
	        Endpoint.publish("http://localhost:8086/Reservation", new ReservationService());
	  }
}
