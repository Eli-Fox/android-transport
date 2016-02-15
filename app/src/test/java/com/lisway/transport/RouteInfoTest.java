package com.lisway.transport;

import com.lisway.transport.type.ProviderType;
import com.lisway.transport.type.TravelType;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RouteInfoTest {

    @Test
    public void testGetTravelType() {
        TravelType travelType = TravelType.getType("walking");
        assertEquals("Should be equal", travelType, TravelType.WALKING);
    }

    @Test
    public void testFailGetTravelType() {
        TravelType travelType = TravelType.getType("parking");
        assertNotEquals("Should be not equal", travelType, TravelType.WALKING);
    }

    @Test
    public void testNullGetTravelType() {
        TravelType travelType = TravelType.getType("jumping");
        assertEquals("Should be equal", travelType, null);
    }

    @Test
    public void testGetProviderType() {
        ProviderType providerType = ProviderType.getType("vbb");
        assertEquals("Should be equal", providerType, ProviderType.VBB);
    }

    @Test
    public void testFailGetProviderType() {
        ProviderType providerType = ProviderType.getType("vbb");
        assertNotEquals("Should be not equal", providerType, ProviderType.GOOGLE);
    }

    @Test
    public void testNullGetProviderType() {
        ProviderType providerType = ProviderType.getType("TAXI");
        assertEquals("Should be equal", providerType, null);
    }

}
