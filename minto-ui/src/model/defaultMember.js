import { defaultApplication } from "./defaultApplication";

export const defaultMember = {
    id: null,
    userId: null,
    membershipNumber: "",
    memberCreatedAt: "",
    memberUpdatedAt: "",
    application: { ...defaultApplication }
};