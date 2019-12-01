package lt.vitkusmindaugas.currency.repository;

import lt.vitkusmindaugas.currency.model.Items;

public interface CurrencyRepository {

	public Items getAllCurrencyByDates(String startDate, String endDate, String currency);

	public Items getCurrencyNames();

}
