package io.reactivesw.product.application.model.mapper;

import io.reactivesw.model.LocalizedString;
import io.reactivesw.product.domain.model.LocalizedStringEntity;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Davis on 16/11/30.
 */
public final class LocalizedStringMapper {

  /**
   * Convert to localized string.
   * when localizedStringEntity is null return new LocalizedString.
   *
   * @param localizedStringEntities the localized string entity
   * @return the localized string
   */
  public static LocalizedString entityToModelDefaultNew(Set<LocalizedStringEntity>
                                                                       localizedStringEntities) {
    LocalizedString localizedString = new LocalizedString();
    if (localizedStringEntities != null) {
      localizedString = entityToModel(localizedStringEntities);
    }
    return localizedString;
  }

  /**
   * Convert to localized string.
   * when localizedStringEntity is null return null.
   *
   * @param localizedStringEntities the localized string entity
   * @return the localized string
   */
  public static LocalizedString entityToModelDefaultNull(Set<LocalizedStringEntity>
                                                                        localizedStringEntities) {
    LocalizedString localizedString = null;
    if (localizedStringEntities != null) {
      localizedString = entityToModel(localizedStringEntities);
    }
    return localizedString;
  }


  /**
   * Convert to Set of LocalizedStringEntity from LocalizedString.
   *
   * @param localizedString the LocalizedString
   * @return Set of LocalizedStringEntity
   */
  public static Set<LocalizedStringEntity> modelToEntityDefaultNew(LocalizedString
                                                                               localizedString) {
    Set<LocalizedStringEntity> localizedStringEntities = new HashSet<>();

    if (localizedString != null && ! localizedString.getLocalized().isEmpty()) {
      Set<Map.Entry<String, String>> localizedStrings = localizedString.getLocalized().entrySet();
      for (Map.Entry localizedValue : localizedStrings) {
        localizedStringEntities.add(new LocalizedStringEntity(localizedValue.getKey().toString(),
            localizedValue.getValue().toString()));
      }
    }

    return localizedStringEntities;
  }

  public static Set<LocalizedStringEntity> modelToEntityDefaultNull(LocalizedString
                                                                              localizedString) {
    Set<LocalizedStringEntity> localizedStringEntities = null;

    if (localizedString != null && ! localizedString.getLocalized().isEmpty()) {
      localizedStringEntities = new HashSet<>();
      Set<Map.Entry<String, String>> localizeStrings = localizedString.getLocalized().entrySet();
      for (Map.Entry localizedValue : localizeStrings) {
        localizedStringEntities.add(new LocalizedStringEntity(localizedValue.getKey().toString(),
            localizedValue.getValue().toString()));
      }
    }

    return localizedStringEntities;
  }

  /**
   * Convert to localized string.
   *
   * @param localizedStringEntities localizedStringEntities
   * @return LocalizedString
   */
  private static LocalizedString entityToModel(Set<LocalizedStringEntity>
                                                              localizedStringEntities) {
    LocalizedString localizedString = new LocalizedString();
    for (LocalizedStringEntity localizedStringEntity : localizedStringEntities) {
      localizedString.addKeyValue(localizedStringEntity.getLanguage(), localizedStringEntity
          .getText());
    }
    return localizedString;
  }

}
