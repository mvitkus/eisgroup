package lt.vitkusmindaugas.currency.service;

import lt.vitkusmindaugas.currency.model.Items;


public interface CurrencyService {
	
	public Items getAlldataFromXML(String startDate, String endDate, String currency);
	public Items getCurrencyNames();

}
