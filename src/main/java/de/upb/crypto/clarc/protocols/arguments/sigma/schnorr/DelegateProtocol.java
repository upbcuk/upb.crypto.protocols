package de.upb.crypto.clarc.protocols.arguments.sigma.schnorr;

import de.upb.crypto.clarc.protocols.CommonInput;
import de.upb.crypto.clarc.protocols.SecretInput;
import de.upb.crypto.clarc.protocols.arguments.sigma.schnorr.variables.SchnorrVariableAssignment;
import de.upb.crypto.math.serialization.Representation;

public abstract class DelegateProtocol extends SendThenDelegateProtocol {

    @Override
    protected SendThenDelegateFragment.ProverSpec provideProverSpec(CommonInput commonInput, SecretInput secretInput, SendThenDelegateFragment.ProverSpecBuilder builder) {
        builder.setSendFirstValue(SendThenDelegateFragment.SendFirstValue.EMPTY);
        return provideProverSpecWithNoSendFirst(commonInput, secretInput, builder);
    }

    protected abstract SendThenDelegateFragment.ProverSpec provideProverSpecWithNoSendFirst(CommonInput commonInput, SecretInput secretInput, SendThenDelegateFragment.ProverSpecBuilder builder);

    @Override
    protected SendThenDelegateFragment.SendFirstValue recreateSendFirstValue(CommonInput commonInput, Representation repr) {
        return SendThenDelegateFragment.SendFirstValue.EMPTY;
    }

    @Override
    protected SendThenDelegateFragment.SendFirstValue simulateSendFirstValue(CommonInput commonInput) {
        return SendThenDelegateFragment.SendFirstValue.EMPTY;
    }

    @Override
    protected SendThenDelegateFragment.SubprotocolSpec provideSubprotocolSpec(CommonInput commonInput, SendThenDelegateFragment.SendFirstValue sendFirstValue, SendThenDelegateFragment.SubprotocolSpecBuilder builder) {
        return provideSubprotocolSpec(commonInput, builder);
    }

    protected abstract SendThenDelegateFragment.SubprotocolSpec provideSubprotocolSpec(CommonInput commonInput, SendThenDelegateFragment.SubprotocolSpecBuilder builder);

    @Override
    protected boolean provideAdditionalCheck(CommonInput commonInput, SendThenDelegateFragment.SendFirstValue sendFirstValue) {
        return true;
    }
}
