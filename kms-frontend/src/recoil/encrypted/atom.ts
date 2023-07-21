import { atom } from 'recoil'

const encryptedMessagesAtom = atom<string[]>({
  key: 'encryptedMessagesAtom',
  default: [],
})

export default encryptedMessagesAtom;
