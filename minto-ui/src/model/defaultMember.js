import { defaultApplication } from "./defaultApplication";
import { defaultPerson } from "./defaultPerson";
import { defaultUser } from "./defaultUser";

export const defaultMember = {
    id: null,
    membershipNumber: "",
    user: { ...defaultUser  },
    person: { ...defaultPerson },
    application: { ...defaultApplication },
    membershipStatus: "",
    startDate: "",
    endDate: "",
    renewalDate: "",
    terminationDate: "",
    memberCreatedAt: "",
    memberUpdatedAt: "",
    notes: "",
    terminationReason: "",
};