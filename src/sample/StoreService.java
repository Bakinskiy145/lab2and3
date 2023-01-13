package sample;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService(serviceName = "DisplayAssortment", portName = "DisplayAssortmentPort", targetNamespace = "http://asu.dgtu.donetsk.ua/ex/passexam")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public class StoreService {
    // store smartphone assortment
    private static Smartphone[] smartphoneData = {
            new Smartphone("1", "IPHONE", "13 PRO MAX", "red", 6, 512, 135999),
            new Smartphone("2", "POCO", "CLASS", "blue", 6, 128, 20720),
            new Smartphone("3", "SAMSUNG", "GALAXY S22", "violet", 8, 256, 68499),
            new Smartphone("4", "XIAOMI", "REDMI NOTE 10S", "black", 6, 128, 17499),
            new Smartphone("5,", "REALME", "9 PRO+", "green", 8, 256, 35999)
    };
    // the number of products in the store
    private static int[] quantityData = {5, 5, 5, 5, 5};
    private static StoreAssortment storeAssortment = new StoreAssortment(smartphoneData, quantityData);

    @WebMethod(operationName = "GetStoreAssortment")
    public StoreAssortment getStoreAssortment() {
        return storeAssortment;
    }

}