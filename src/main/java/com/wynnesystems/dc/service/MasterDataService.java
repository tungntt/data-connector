package com.wynnesystems.dc.service;

import java.util.List;
import java.util.Map;

public interface MasterDataService {

    List<Map<String, Object>> executeMasterDataById(final long id);
}
