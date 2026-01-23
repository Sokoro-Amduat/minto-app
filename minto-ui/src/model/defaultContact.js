import { defaultAddress } from "./defaultAddress";
import { defaultEmail } from "./defaultEmail";
import { defaultPhone } from "./defaultPhone";

export const defaultContact = {
    id: null,
    addresses: [{ ...defaultAddress }],
    emails: [{ ...defaultEmail }],
    phones: [{ ...defaultPhone }],
}