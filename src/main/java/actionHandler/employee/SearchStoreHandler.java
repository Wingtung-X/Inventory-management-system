package actionHandler.employee;

import dao.StoreDAO;


public class SearchStoreHandler {
    public String searchHandler(int idInput){
        StoreDAO storeDAO = new StoreDAO();
        String result = storeDAO.searchStore(idInput);
        return result;
    }
}
