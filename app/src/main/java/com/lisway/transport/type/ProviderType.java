package com.lisway.transport.type;

import com.lisway.transport.model.server.route.Provider;
import com.lisway.transport.model.server.route.ProviderAttributes;

public enum ProviderType {
    VBB("vbb"),
    DRIVE_NOW("drivenow"),
    CAR2GO("car2go"),
    GOOGLE("google"),
    NEXT_BIKE("nextbike"),
    CALL_A_BIKE("callabike");

    private String name;

    ProviderType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ProviderType getType(String value) {
        ProviderType travelType = null;
        for (ProviderType type : values()) {
            if (value.equalsIgnoreCase(type.getName())) {
                travelType = type;
                break;
            }
        }
        return travelType;
    }

    public static Provider getProvider(String providerName, ProviderAttributes providers) {
        Provider provider = null;
        ProviderType providerType = getType(providerName);
        if (providerType != null) {
            switch (providerType) {
                case VBB:
                    provider = providers.getVbb();
                    break;
                case DRIVE_NOW:
                    provider = providers.getDrivenow();
                    break;
                case CAR2GO:
                    provider = providers.getCar2go();
                    break;
                case GOOGLE:
                    provider = providers.getGoogle();
                    break;
                case NEXT_BIKE:
                    provider = providers.getNextbike();
                    break;
                case CALL_A_BIKE:
                    provider = providers.getCallabike();
                    break;
                default:
                    break;
            }
        }
        return provider;
    }
}
