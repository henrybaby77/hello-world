package com.henrybaby.paperartist;

import com.henrybaby.paperartist.slice.MainAbilityDetailSlice;

import manager.NewsDemoIDLStub;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.rpc.IRemoteObject;

/**
 * Shared Service
 */
public class SharedService extends Ability {
    private static final String DESCRIPTOR = "com.henrybaby.paperartist.idl.INewsDemoIDL";

    private static final String ACTION = "action.detail";

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
    }

    @Override
    protected IRemoteObject onConnect(Intent intent) {
        return new MyBinder(DESCRIPTOR);
    }

    /**
     * MyBinder
     */
    private class MyBinder extends NewsDemoIDLStub {
        MyBinder(String descriptor) {
            super(descriptor);
        }

        @Override
        public void tranShare(String title, String reads, String likes, String content, String image) {
            Intent intent = new Intent();
            Operation operation =
                    new Intent.OperationBuilder()
                            .withBundleName(getBundleName())
                            .withAbilityName(MainAbility.class.getName())
                            .withAction(ACTION)
                            .build();
            intent.setOperation(operation);
            intent.setParam(MainAbilityDetailSlice.INTENT_TITLE, title);
            intent.setParam(MainAbilityDetailSlice.INTENT_READ, reads);
            intent.setParam(MainAbilityDetailSlice.INTENT_LIKE, likes);
            intent.setParam(MainAbilityDetailSlice.INTENT_CONTENT, content);
            intent.setParam(MainAbilityDetailSlice.INTENT_IMAGE, image);
            startAbility(intent);
        }
    }
}
